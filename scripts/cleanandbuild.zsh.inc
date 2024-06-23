

function cleanandbuild() {
    
    PROJECTDIR="$1";shift;

    # JARDIR
    JARDIR="$1";shift;
    
    # JAR
    JAR="$1";shift;
    
    echo "$PROJECTDIR/$JARDIR/$JAR"
    
    # cd to projectdir
    cd "$PROJECTDIR"
    pwd
    # clean project
    ./gradlew clean
    
    
    # build project
    ./gradlew build
    
    # check exit code
    if (( $? != 0 )); then
        echo "Gradle error: build"
        exit
    fi;
    
    # cd to JARDIR
    cd "$JARDIR"
    
    # java -jar build.jar
    java -jar "$JAR"

}
