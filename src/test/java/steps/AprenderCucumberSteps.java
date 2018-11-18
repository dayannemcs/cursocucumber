package steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {
	@Dado("^eu que criei o arquivo corretamente$")
	public void euQueCrieiOArquivoCorretamente() throws Throwable {
	    
	}

	@Quando("^eu executá-lo$")
	public void euExecutáLo() throws Throwable {
	   
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	   
	}
	
	//segundo cenário
	private int cont = 0;
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
	    cont = arg1;
	    System.out.println(arg1);
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int num) throws Throwable {
	    cont = cont + num;
	    System.out.println(num);
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int resul) throws Throwable {
	   System.out.println(resul);	  
	   Assert.assertEquals(resul, cont);
	}
	
	//cenário 3
	
	Date entrega = new Date();
	Calendar cal = Calendar.getInstance();
	
	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) throws Throwable {	    
	    entrega = data;
	    System.out.println(entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (.+)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	 cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("meses")) {
	    	 cal.add(Calendar.MONTH, arg1);
	    }   
	   
	    entrega = cal.getTime();
	    System.out.println(arg1);
	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    Assert.assertEquals(data, dataFormatada);
	    System.out.println(data);
	}
	
	@Dado("^que o ticket( especial)? é A.(\\d+)$")
	public void queOTicketÉAF(String tipo, int arg1) throws Throwable {
	    
	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double valor) throws Throwable {
		System.out.println(valor);
	    
	}

	@Dado("^que o nome do passageiro é \"(.*)\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	    
	}

	@Dado("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	public void queOTelefoneDoPassageiroÉ(int arg1, int arg2) throws Throwable {
	   
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	
	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	   
	}

}
