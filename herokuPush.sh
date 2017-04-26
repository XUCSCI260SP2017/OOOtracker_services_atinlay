echo "Give commit message: "
read commitMessage
heroku git:remote -a atin-lay-time-management
gradle clean wrapper build
git add * "--force"
git commit "-am $commitMessage"
git push heroku master "--force"

