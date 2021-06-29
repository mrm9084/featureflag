# Getting Started

## Setup Azure App Configuration

Create a Azure App Configuration Store and adds a Feature Flag called Beta.

```cli
az appconfig create -n demo-store --sku standard
az appconfig feature set -n demo-store --feature Beta --yes
```

## Setup Application

Get Connection String

```cli
az appconfig credential list --name demo-store
```

Setup Environment Variable, you will want the value from the last command with the name "Primary Read Only"

```cli
setx APP_CONFIGURATION_CONNECTION_STRING "<Your Primary Read Only Connection String>"
```

Restart you Command Prompt to get the new Environment Variable

## Run Application

Build and run the application.

```cli
mvn clean compile spring-boot:run
```

Go to `localhost:8080` and you will see the message `Message: Beta Off`

Open a new cli and turn the feature flag on.

```cli
az appconfig feature enable -n demo-store --feature Beta --yes
```

Configuration/Feature Flags only refresh every 30s by default. Refresh `localhost:8080` a few times and you will see the message `Message: Beta On`

Note: You will also see this in the logs.

```cli
Refresh keys changed: [feature-management.featureManagement]
```
