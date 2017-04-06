cd src/main/resources
git config credential.helper store
echo "Give a commit message:"
read commitMessage
git add *
git commit "-m $commitMessage"
git push "--force" origin master
cd ../../..
