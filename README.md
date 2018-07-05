# Writing githooks in Kotlin

Code repository for article ["Writing githooks in Kotlin"](https://jivimberg.io/blog/2018/07/03/writing-githooks-in-kotlin/)

## Requirements

To be able to run Kotlin as a script you'll need to install [KScript](https://github.com/holgerbrandl/kscript) you can find the installation instructions [here](https://github.com/holgerbrandl/kscript#installation).

## Running it

Doing a `gradle build` will install the githook pre-push script. You can check [this line](build.gradle.kts#L43) to see how this is achieved.

Next time you do `git push` [the script](pre-push.kts) will be executed. As part of the script `gradle check` will be executed. If the run is successful you'll be able to push, otherwise the push will be aborted.

For a more in-depth explanation of the code check the article: https://jivimberg.io/blog/2018/07/03/writing-githooks-in-kotlin/