git config crendential.helper store
rm -rf src/main/resources
git clone https://github.com/XUCSCI260SP2017/OOOtracker_UI_Atinlay.git src/main/resources
cd src/main/resources
git config credential.helper store
cd ../../..
echo "resources installed"

