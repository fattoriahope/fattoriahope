package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.JavaMailUtil;

/**
 * Servlet implementation class Contatti
 */
@WebServlet("/contatti")
public class Contatti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contatti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String textArea = request.getParameter("textarea");
		
		String intestazioneUtente = "Grazie per averci contattato";
		String intestazioneWeb = "Richiesta di contatto";
		String testoHtmlUtente = " <!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				  "<meta charset=UTF-8>" +
				  "<title>Notifica di Contatto</title>" +
				 
				    /* Stili CSS per la formattazione */
				   
				 
				"</head>" +
				"<body style=font-family: Arial, sans-serif;>" +
				  "<div class=container>" +
				    "<h1>" + "Caro " + nome + " "  + "</h1>" +
				    "<p>" + "Abbiamo appena ricevuto la tua richiesta."
					+ "Tra poco verrai contattato dal nostro Team Supporto, la preghiamo di "
					+ "avere pazienza nel caso potrebbe richiederci più tempo. " + "</p>" +
				    
				   "<p> Ecco il problema che hai riscontrato: </p>" +
				   textArea +
				   " <a class=button href= >" + "dev4uinfoservizi@gmail.com" +  "</a>" +
				 " </div>" +
				"</body>" +
				"</html> ";
		String testoHtmlWeb = " <!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				  "<meta charset=UTF-8>" +
				  "<title>Richiesta di contatto</title>" +
				 
				    /* Stili CSS per la formattazione */
				   
				 
				"</head>" +
				"<body style=font-family: Arial, sans-serif;>" +
				  "<div class=container>" +
				    "<h1> Contatto utente </h1>" +
				    "<p>" + "<br>Nome: "+ nome
					+ "<br>Email: " + email
					+ "<br>Testo richiesta: "+textArea + "</p>" +
				    
				   " <a class=button href= >" + "dev4uinfoservizi@gmail.com" +  "</a>" +
				 " </div>" +
				"</body>" +
				"</html> ";
				
		try {
			JavaMailUtil.sendMail("dev4uinfoservizi@gmail.com","dev4uinfoservizi@gmail.com", intestazioneWeb, testoHtmlWeb);
			JavaMailUtil.sendMail(email,"dev4uinfoservizi@gmail.com", intestazioneUtente, testoHtmlUtente);
			request.getRequestDispatcher("index.jsp").include(request, response);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
