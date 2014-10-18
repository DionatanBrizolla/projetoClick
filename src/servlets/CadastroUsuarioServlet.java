package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Usuario;
import dao.UsuarioDao;

/**
 * Servlet implementation class CadastroUsuarioServlet
 */
@WebServlet(name="CadastroUsuarioServlet", urlPatterns={"/CadastroUsuarioServlet"})
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastroUsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String dia = request.getParameter("dataNascimento");
		String mes = request.getParameter("mes");
		String ano = request.getParameter("ano");
		String senha = request.getParameter("senha");
		String data = ano + "-" + mes + "-" + dia;
		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(ano), Integer.parseInt(mes),Integer.parseInt(dia));
		
			try{
				if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || sexo.isEmpty()
				  || dia.isEmpty() || mes.isEmpty() || ano.isEmpty()){
				  throw new Exception("campo do formulário em branco");
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		 user.setNome(nome);
		 user.setSobrenome(sobrenome);
		 user.setEmail(email);
		 user.setSexo(sexo);
		 user.setDataNascimento(new java.sql.Date(cal.getTimeInMillis()));
		 user.setSenha(senha);
		 
		 UsuarioDao userDao = new UsuarioDao();
		 try {
			userDao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
		
	}

}
