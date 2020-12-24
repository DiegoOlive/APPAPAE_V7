
package controle;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.EmailException;


public class OperacaoEmail {
    private String sender="apaecontatorec@gmail.com";
	private String pwd="apae123456";
	private String destino;
	private String assunto= "ALTERAÇÃO DE SENHA!";
	private String msg="Alterando senha";
	private String senha;
	private Properties props=new Properties();
	public OperacaoEmail(String destino, String senha) throws EmailException{
		this.destino=destino;
		this.senha=senha;
		setMsg(senha);
		enviar();
	}
	String getSender() {
		return this.sender;
	}
	String getPwd() {
		return this.pwd;
	}
	String getDestino() {
		return this.destino;
	}
	String getAssunto() {
		return this.assunto;
	}
	String getMessage() {
		return this.msg;
	}
	public void setSender(String sender) {
		this.sender=sender;
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	public void setDestino(String destino) {
		this.destino=destino;
	}
	public void setAssunto(String assunto) {
		this.assunto=assunto;
	}
	public void setMsg(String senha) {
		this.msg="Olá usuário, sua nova senha é: "+senha+". Para modificá-la, basta acessar o sistema e atualizar seus dados da conta!";
	}
	public void enviar() throws EmailException{
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
	    Session session = Session.getDefaultInstance(props,
	    	      new javax.mail.Authenticator() {
	    	           protected PasswordAuthentication getPasswordAuthentication() 
	    	           {
	    	                 return new PasswordAuthentication(getSender(), 
	    	                 getPwd());
	    	           }
	    	      });
	    	 
	    	    /** Ativa Debug para sessão */
	    	    session.setDebug(true);
	    	    try {	    	    	 
	    	        Message message = new MimeMessage(session);
	    	        message.setFrom(new InternetAddress(sender)); 
	    	        //Remetente
	    	   
	    	        Address[] toUser = InternetAddress.parse(destino);  
	    	   
	    	        message.setRecipients(Message.RecipientType.TO, toUser);
	    	        message.setSubject(assunto);//Assunto
	    	        message.setText(msg);
	    	        /**Método para enviar a mensagem criada*/
	    	        Transport.send(message);	    	   
	    	       } catch (MessagingException e) {
	    	          throw new RuntimeException(e);
	    	      }
		
	}
}

