package br.com.crud.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 * @author João Manoel Santos Almeida
 * @since Abril de 2023
 * @implNote Exibição de mensagens para o usuário. Deve ser chamada na bean para mostrar 
 * alguma mensagem para o usuário.
 * */
public class MensagemUtil {
	
	public static void adicionarMensagemConfirmacao(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();         
		context.addMessage(null, new FacesMessage(mensagem) );
	}
	public static void adicionarMensagemErro(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msm = new FacesMessage(mensagem);
		msm.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null,msm);
		
	}

}
