# Sams Teach Yourself Java in 21 Days

## Day 3: Working with Objects

### Creating New Objects

Classes are templates (blueprints) used to create objects.

The String class is unusuall in that respect. Although it's a class,
it can be assigned a value with a literal as if it were a primitive type.

#### Using New

```
String name = new String("Hall Jordan");
URL address = new URL("http://www.java21days.com");
Volcanorobot robbie = new VolcanoRobot();
```

```
Random seed = new Random(606843071);
Point pt = new Point(0,0);
```
The number and type of arguments to include inside the parentheses are defined by
the class itself using a special method called a *constructor*.

