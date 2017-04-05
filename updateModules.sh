git config credential.helper store
cd src/main/resources
echo "Give a commit message:"
read commitMessage
git add *
git commit "-m $commitMessage"
git push "--force" origin master
cd ../../..
