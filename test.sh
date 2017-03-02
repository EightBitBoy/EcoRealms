echo "###--- Starting the tests."
echo "Hello from test.sh!"
ls $TRAVIS_BUILD_DIR
/opt/Unity/Editor/Unity -batchmode -projectPath $TRAVIS_BUILD_DIR
