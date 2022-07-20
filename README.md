
# QwarySurvey
Android Library for survey which enables you to integrate feedback into Android app using few lines of code.

## Example

Create a QwarySurvey Builder Object

```java
Survey builder = new Survey.Builder()

```

Then set the fields you want.

```java
  new Survey.Builder()
                .setActivity(this)
                .setDomain("domain_url")
                .setToken("survey_token")
                .setLoader(true) //For loading bar visibility
                .setModal(false) //For full and half view
                .setStartAfter(TimeUnit.MINUTES.toMillis(1L)) //To start survey after 1 minute
                .prepare();
```

You can prepare the schedule survey to start after HOURS or DAYS

```java
.setStartAfter(TimeUnit.HOURS.toMillis(1L)) //To start after 1 hour
.setStartAfter(TimeUnit.DAYS.toMillis(1L)) //To start after 1 day

```
To show the the survey at once without any delay

```java
  new Survey.Builder()
                .setActivity(this)
                .setDomain("domain_url")
                .setToken("survey_token")
                .showNow();

```
To remove the specific survey from schedule
```java
new Survey.Builder().setActivity(this).clear("token");
```
Add below into app gradle

```java
  android {
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
  }
```