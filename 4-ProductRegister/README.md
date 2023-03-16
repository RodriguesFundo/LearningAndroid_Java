# <strong>REGISTRO DE PRODUTOS</strong>
 
Uma aplicação de registo de produtos

## Composição e Funcionamento

<br>
<p>Ela tem um layout composto por um formulário com os seguintes campos:</p> 

- <Strong>Name:</Strong> Onde ira receber o nome do produto
- <Strong>Price:</Strong> Onde ira receber o preço do produto
- <Strong>Quantity:</Strong> Onde ira receber a quantidade produto
- <Strong>Exp:</Strong> Onde ira receber a data de validade do produto

- <Strong>Register Product:</Strong> Um botão que fará o registo de produtos

<hr>
<p>O usuário preenche os dados do produto (acima descrito) e ao clicar no botão, ele insere os dados numa estrutura de dados (neste caso <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"><i>ArrayList</i></a>
)</p>
<p>Se a operação de inserção for bem sucedida, ira mostrar uma mensagem de sucesso na própria tela, caso contrario, uma mensagem de erro em forma de <a href="https://developer.android.com/guide/topics/ui/notifiers/toasts"><i>Toast</i></a>
</p>

<p>Na consola do Android Studio, será impresso todos os produtos existentes </p>

<hr><hr><hr>

## Extras

<p> A partir deste ponto, para poder "pegar" os dados que estao no meu layout e usar na minha classe.java, passarei a usar o <a href="https://developer.android.com/topic/libraries/data-binding"><i>dataBinding</i></a>
.</p>

<p>Para usarmos este recurso, devemos seguir os seguintes passos:</p>

- <strong>Activar o biding no Ficheiro build.gradle(Module:app)</strong>


	android{
        
		buildFeatures{
        		viewBinding true
    		}
	}

- <strong>Sincronizar o seu projecto (<i>Sync</i>)</strong>

- <strong>Importar o binding na classe que se pretnde usar o binding</strong>

    import com.xxx.package.databinding.NomeBinding; //Nome da Classe que sera gerada

- <strong>Criar um atributo daquela classe, instanciar e adicionar a nova view parametro do ContentView </strong> 

        private NomeClasseBinding NomeBinding;
        main(){
        	onCreate(...){
	            super.OnCreate(...);
	            NomeBinding = NomeClasseBinding.inflate(getLayoutInflater());
	            View view = NomeBinding.getRoot();
	            setContentView(view);	
            }
        }


<p>Apos concluir esses passos, o recurso do databinding pode ser usado sem ter de usar os objectos que estão no arquivo XML. Para tal , usamos a seguinte estrutura: </p>

NomeBindig.var.setText("");

NomeBindig.var.getText();

<hr/>
<hr/>

<div style="text-align: center; width: 100%;">
  <img style="display: inline-block; margin: 0 10px;" width="30%" alt="Tela1" src="https://user-images.githubusercontent.com/105431834/225765187-43522198-b1a2-46ab-a2fc-6e4bef8365a4.jpeg"/>
  <img style="display: inline-block; margin: 0 10px;" width="30%" alt="Tela1" src="https://user-images.githubusercontent.com/105431834/225767317-c61d6313-b319-4380-8fbb-ca7898a1847d.jpeg"/>
  <img style="display: inline-block; margin: 0 10px;" width="30%" alt="Tela1" src="https://user-images.githubusercontent.com/105431834/225767549-3f11cd6c-7547-442e-9dc7-1cb8142a417c.jpeg"/>
</div>
<hr/>

https://user-images.githubusercontent.com/105431834/225772040-56cf49ed-2468-4329-8e35-706ef914a459.mp4




