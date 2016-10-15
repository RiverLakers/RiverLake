# github.py
from flask import (Flask, flash, request, redirect,
    render_template, url_for, session)


from rauth.service import OAuth2Service

# Flask config
SECRET_KEY = '\xfb\x12\xdf\xa1@i\xd6>V\xc0\xbb\x8fp\x16#Z\x0b\x81\xeb\x16'
DEBUG = False

# Flask setup
app = Flask(__name__)
app.config.from_object(__name__)

# Use your own values in your real application
github = OAuth2Service(
    name='github',
    base_url='https://api.github.com/',
    access_token_url='https://github.com/login/oauth/access_token',
    authorize_url='https://github.com/login/oauth/authorize',
    client_id= '9f7cc4cd55a8222083c7',
    client_secret= '1114f30fe60553c2651eaa8aa876f63f5cbd5f6c',
)

# models
# class User(db.Model):

# views
@app.route('/')
def index():
    return render_template('login.html')


@app.route('/login')
def login():
    redirect_uri = url_for('authorized', next=request.args.get('next') or
        request.referrer or None, _external=True)
    print(redirect_uri)
    # More scopes http://developer.github.com/v3/oauth/#scopes
    params = {'redirect_uri': redirect_uri, 'scope': 'user'}
    print(github.get_authorize_url(**params))
    return redirect(github.get_authorize_url(**params))

# same path as on application settings page
@app.route('/github/callback')
def authorized():
    # check to make sure the user authorized the request
    if not 'code' in request.args:
        flash('You did not authorize the request')
        return redirect(url_for('index'))

    # make a request for the access token credentials using code
    redirect_uri = url_for('authorized', _external=True)

    data = dict(code=request.args['code'],
        redirect_uri=redirect_uri,
        scope='user,public_repo')

    auth = github.get_auth_session(data=data)
    print(auth.access_token)
#    session['token'] = auth.access_token
    return redirect('https://api.github.com/user?access_token='+auth.access_token)

if __name__ == '__main__':
    app.run()
