# SimpleWebWrapper

## What is SimpleWebWrapper?

SimpleWebWrapper is an Android library which helps you creating the activity UI more easier.
You just have to configure the main things instead of coding them yourself.

## How to use SimpleWebWrapper?

### Gradle

SimpleWebWrapper is available via jCenter.

Add this to your build.gradle:

```
 dependencies {
        compile 'jlelse:SimpleWebWrapper:+'
    }
```

That's it!

### Usage in `Activity`

#### 1. Make your Activity extending `jlelse.simplewebwrapper.SimpleWebWrapperActivity`

```java
import jlelse.simplewebwrapper.SimpleWebWrapperActivity;

public class SampleActivity extends SimpleWebWrapperActivity {
```

#### 2. Implement all abstract methods

You can do this by using the *Implement Methods* options from Android Studios context menu.

### Sample activity

There's a sample of how to use the library. You can find it <a href="https://github.com/jlelse/SimpleWebWrapper/tree/master/sample">here</a>

## Dependencies

SimpleUI has the following Gradle dependencies:

```
compile 'jlelse:SimpleUI:+'
```

## Credits

**Developer:** <a href="https://github.com/jlelse">jlelse</a>

## License

SimpleWebWrapper is licensed under the Apache 2.0 license

```
   Copyright 2015 Jan-Lukas Else

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```