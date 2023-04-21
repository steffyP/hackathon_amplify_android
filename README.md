# Hackathon Project "In the customer's shoes": Android & Amplify

Goal of the project is to make an Amplify powered Android app that uses LocalStack.

## Initial Idea
FoodStorageTracker can be used to add products (including expiration date) to keep track of the storage, and to be notified when a product is about to expire.
Additionally, receipes can be suggested to use the products.

### Services
* Cognito (registration/login)
* Dynamodb (sync data about products)
* S3 (photo upload)
* Lambda (notifications)

### Implementation Status
* Cognito (registration + login)

## Setup
* install amplify and [amplify plugin for localstack](https://github.com/localstack/amplify-localstack/)
* start LocalStack
* in the project run: `amplify init --use-localstack true` 
  * ```bash
    Info:    Patching AWS Amplify libs
    Note: It is recommended to run this command from the root of your app directory
    ? Enter a name for the project FoodStorageTracker
    The following configuration will be applied:
    
    Project information
    | Name: FoodStorageTracker
    | Environment: dev
    | Default editor: Visual Studio Code
    | App type: android
    | Res directory: app/src/main/res
    
    ? Initialize the project with the above configuration? No
    ? Enter a name for the environment dev
    ? Choose your default editor: Android Studio
    ? Choose the type of app that you're building android
    Please tell us about your project
    ? Where is your Res directory:  app/src/main/res
    Using default provider  awscloudformation
    ? Select the authentication method you want to use: AWS profile
    ```

* next configure authentication `amplify add auth --use-localstack true`
  * ```bash
    Using service: Cognito, provided by: awscloudformation

    The current configured provider is Amazon Cognito.
    
    Do you want to use the default authentication and security configuration? Default configuration
    Warning: you will not be able to edit these selections.
    How do you want users to be able to sign in? Username
    Do you want to configure advanced settings? No, I am done.
    ``` 
    
* then push the configuration `amplify push --use-localstack true`
* when everything worked successfully, there are two files created in `app/src/main/res`:
  * `amplifyconfiguration.json` and `awsconfiguration.json`
  * open both files and add the endpoint for each configuration, 
    * e.g. `"Endpoint": "cognito-idp.localhost.localstack.cloud"`
    * for `CognitoIdentity.Default` and `CognitoUserPool.Default`

* make sure LocalStack is reachable using https on the default port
  * e.g. if DEBUG=1, you should be able to access this page in the webbrowser [https://localhost.localstack.cloud/_localstack/health](https://localhost.localstack.cloud/_localstack/health)
  * if this is not the case, please use socat to forward the traffic to whatever port is reachable over https, e.g.
    ```
    socat TCP-LISTEN:443,fork TCP:localhost.localstack.cloud:4566`
    ````

* To make LocalStack available on your testing device or emulator, you have to redirect the traffic:
   ```bash 
    adb root               
    adb reverse tcp:443 tcp:443
    ```

* Start the app
* Create a new user for the registration
* You will be asked for a token to enter -> this token is in the LocalStack Logs and needs to be entered here
* You can logout (using the context-menu) and login from the start screen
* Currently only random Products are added to the list, those are stored locally only (there is no link to the currently logged in user)