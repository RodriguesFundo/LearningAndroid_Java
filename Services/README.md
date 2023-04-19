# <strong>[Serviços](https://developer.android.com/guide/components/services?hl=pt-br#java)</strong>


 
<b>Serviços</b> são componentes do Android que executam operações em segundo plano, sem a necessidade de interação com o usuário.
<hr>

## Tipos de serviços 

1. Serviço Iniciado (Started Service)

   1.1. O serviço de intenção (ou Intent Service)

2. Serviço Vinculado (Bound Service)

<hr>

## Anatomia de serviços

Um serviço no Android deve ser criado como uma subclasse da classe Serviço Android/Android Service (***android.app.Service***) ou de uma de suas subclasses, (***android.app.IntentService***).
E, dependendo do tipo de serviço que está sendo criado, um ou mais dos métodos de retorno de chamada de superclasse devem ser substituídos. 
<br/><br/>
A classe IntentService já inclui suas próprias implementações de onStartCommand() e onBind() para que elas não precisem ser implementadas em subclasses.

- <strong>[onStartCommand()](https://developer.android.com/reference/android/app/IntentService#onStartCommand(android.content.Intent,%20int,%20int))</strong>: é chamado quando o serviço é iniciado por outro componente através do método startService(). Se o serviço for vinculado, esse método não precisa ser implementado.

- <strong>[onBind()](https://developer.android.com/reference/android/app/Service#onBind(android.content.Intent))</strong>: é chamado quando um componente se liga ao serviço através do método bindService(). Se o serviço for acoplado, este método deve retornar um objeto IBinder que permita a comunicação com o cliente. Para serviços iniciados, este método deve retornar um valor NULL.

- <strong>[onCreate()](https://developer.android.com/reference/android/app/IntentService#onCreate())</strong>: é um local destinado para realizar tarefas de inicialização. Este método é chamado imediatamente antes da chamada a onStartCommand() ou na primeira chamada ao onBind().

- <strong>[onDestroy()](https://developer.android.com/reference/android/app/IntentService#onDestroy())</strong>: é chamado quando o serviço está sendo destruído.

- <strong>[onHandleWork()](https://developer.android.com/reference/android/app/IntentService#onHandleIntent(android.content.Intent))</strong>: é aplicável somente a subclasses JobIntentService. Este método é chamado para manipular o processamento do serviço e é executado em uma thread separada do aplicativo principal.


Leia mais sobre ***[serviços](https://developer.android.com/guide/components/services?hl=pt-br#java)***