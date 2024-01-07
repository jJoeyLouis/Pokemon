After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


# To run the application - Add by Joey

With no option 
```
run --args="2"
```

With SQL 
```
run --args="2 -d ../sujet_TP/ressources/pokemondatabase.sqlite"
```

With SQL + CSV 
```
run --args="2 -d ../sujet_TP/ressources/pokemondatabase.sqlite -f csv"
```

# Build the project

```
./gradlew build
```



# Run the application

```
./gradlew run
```

To run the application with command line arguments :

```
./gradlew run --args="premierArgument secondArgument"
```


# Run the tests

```
./gradlew test
```
