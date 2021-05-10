Api was generated from example
https://app.swaggerhub.com/apis/otus55/users/1.0.0
using
https://editor.swagger.io/
and then was small refactored.

Запуск

```aidl
cd k8s
kubectl apply -f .
```

ждем пока все поднимется

```aidl
minikube service kuber-crud
```

Получаем

```aidl
...
 Starting tunnel for service kuber-crud-service.
|-----------|--------------------|-------------|------------------------|
| NAMESPACE |        NAME        | TARGET PORT |          URL           |
|-----------|--------------------|-------------|------------------------|
| default   | kuber-crud-service |             | http://127.0.0.1:43675 |
|           |                    |             | http://127.0.0.1:38185 |
|-----------|--------------------|-------------|------------------------|

```

Далее заходим http://127.0.0.1:43675/api/v1
там будет swagger с помощью него 
