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
 * Servlet implementation class Acquista
 */
@WebServlet("/acquista")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acquista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String intestazioneS = "Ordine effettuato";
		
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email=request.getParameter("email");
		String citta=request.getParameter("citta");
		String provincia=request.getParameter("provincia");
		String indirizzo=request.getParameter("indirizzo");
		String civico=request.getParameter("civico");
		String cap=request.getParameter("cap");
		String cesto=request.getParameter("cesto");
		String note=request.getParameter("note");
		if(note==null || note.equals(""))
			note="Nessuna nota";
		double prezzo;
		if(cesto.equals("cesto1KG"))
			prezzo=9.99;
		else if(cesto.equals("cesto2KG"))
			prezzo=17.99;
		else if(cesto.equals("cesto3KG"))
			prezzo=25.99;
		else
			prezzo=35.99;
	    String testoHtmlS =" <!DOCTYPE html>" +
					"<html>" +
					"<head>" +
					  "<meta charset=UTF-8>" +
					  "<title>Notifica di vendita</title>" +
					 
					    /* Stili CSS per la formattazione */
					   
					 
					"</head>" +
					"<body style=font-family: Arial, sans-serif;>" +
					  "<div class=container>" +
					    "<h1>" + "Grazie per il tuo acquisto! </h1>" +
					    "<p>" + "Questo è il riepilogo del tuo ordine:</p>" +
					    "<ul>" +
					      "<li><strong>Nome: </strong>" + nome+ "</li>" +
					      "<li><strong>Cognome: </strong>" + cognome + "</li>" +
					      "<li><strong>Email: </strong>" + email + "</li>" +
					      "<li><strong>Cesto: </strong>" + cesto + "</li>" +
					      "<li><strong>Prezzo: </strong>" + prezzo +" da pagare al momento della consegna"+ "</li>" +
					     " </ul>" +
					      "Da spedire a:"+
					     "<ul>"+
					     "<li><strong>Città: </strong>" + citta+ "</li>" +
					      "<li><strong>Provincia: </strong>" + provincia + "</li>" +
					      "<li><strong>Indirizzo: </strong>" + indirizzo+", "+civico + "</li>" +
					      "<li><strong>CAP: </strong>" +cap + "</li>" +
					      "<li><strong>Cesto: </strong>" + cesto + "</li>" +
					      "<li><strong>Eventuali note: </strong>" + note+"</li>" +
					     " </ul>" +
					      
					    "<p> Di seguito trovi la nostra mail per qualsiasi problema tu possa riscontrare: </p>" +
					   " <a class=button href= >" + "ilparadisodeglianimali.gds@gmail.com" +  "</a>" +
					 " </div>" +
					"</body>" +
					"</html> ";
			
					try {
						JavaMailUtil.sendMail(email,"ilparadisodeglianimali.gds@gmail.com", intestazioneS, testoHtmlS);		
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	
	    	

		String intestazioneU = "Notifica di vendita";

		 String testo="<p>" + "Dati anagrafici cliente:</p>" +
				    "<ul>" +
				      "<li><strong>Nome: </strong>" + nome+ "</li>" +
				      "<li><strong>Cognome: </strong>" + cognome + "</li>" +
				      "<li><strong>Email: </strong>" + email + "</li>" +
				     " </ul>" +
				      "Dati spedizione:"+
				     "<ul>"+
				     "<li><strong>Città: </strong>" + citta+ "</li>" +
				      "<li><strong>Provincia: </strong>" + provincia + "</li>" +
				      "<li><strong>Indirizzo: </strong>" + indirizzo+", "+civico + "</li>" +
				      "<li><strong>CAP: </strong>" +cap + "</li>" +
				      "<li><strong>Cesto: </strong>" + cesto + "</li>" +
				      "<li><strong>Prezzo: </strong>" + prezzo +" da pagare al momento della consegna"+ "</li>" +
				      "<li><strong>Eventuali note: </strong>" + note + "</li>" +
				     " </ul>";
		 

		String testoHtmlU = " <!DOCTYPE html>" +
		"<html>" +
		"<head>" +
		  "<meta charset=UTF-8>" +
		  "<title>Notifica di acquisto</title>" +
		 
		    /* Stili CSS per la formattazione */
		   
		 
		"</head>"+
		"<body style=font-family: Arial, sans-serif;>" +
		 testo+
		"</body>" +
		"</html> ";
		 

		
				try {
					JavaMailUtil.sendMail("ilparadisodeglianimali.gds@gmail.com", "ilparadisodeglianimali.gds@gmail.com", intestazioneU, testoHtmlU);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("index.html").include(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
