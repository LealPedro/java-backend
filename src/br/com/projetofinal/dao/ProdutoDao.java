package br.com.projetofinal.dao;

import java.sql.Connection;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.Categoria;
import br.com.projetofinal.model.Produto;
import br.com.projetofinal.model.Tamanho;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

	public void add(Produto produto) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"insert into produto (nome_produto, preco_produto, imagem_produto, desc_produto, categoria_idcategoria, tamanho_idtamanho)values(?,?,?,?,?,?)");
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setString(3, produto.getImagem());
			stmt.setString(4, produto.getDescricao());
			stmt.setInt(5, produto.getCategoria().getId());
			stmt.setInt(6, produto.getTamanho().getId());

			stmt.execute();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt);
		}

	}

	public List<Produto> list() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Produto p = new Produto();
				
				p.setId(rs.getInt("id"));
				
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
	
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				
				p.setCategoria(new Categoria());
				p.getCategoria().setId(rs.getInt("categoria_id"));
				p.getCategoria().setCategoria(rs.getString("categoria"));
				
				p.setTamanho(new Tamanho());
				p.getTamanho().setId(rs.getInt("tamanho_id"));
				p.getTamanho().setTamanho(rs.getString("tamanho"));
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
		stmt = con.prepareStatement("delete from produto where idproduto=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	
	
	public void update(Produto p) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE produto SET nome_produto=?, preco_produto=?, categoria_idcategoria=?, desc_produto=?, imagem_produto=?  WHERE idproduto=?");
			stmt.setString(1, p.getNome());
			stmt.setDouble(2, p.getPreco());
			stmt.setInt(3, p.getCategoria().getId());
			stmt.setString(4, p.getDescricao());
			stmt.setString(5, p.getImagem());
			stmt.setInt(6, p.getId());
			
			stmt.execute();
			
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	
	
	public List<Produto> listSweetPizza() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'doce'");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	public List<Produto> listCrepe() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'crepe'");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	
	public List<Produto> listPizza() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'salgada'");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	public List<Produto> listDriks() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'bebidas'");
			
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	public List<Produto> listPasta() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'espaguete'");
			
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
			    t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	
	public List<Produto> listSobreMesa() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {

			stmt = con.prepareStatement("select * from listprodutos where categoria = 'sobremesa'");
			
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Produto p = new Produto();
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
				produto.add(p);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return produto;
	}
	
	public Produto searchById(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Produto p = new Produto();

		try {
			stmt = con.prepareStatement("select * from listprodutos where id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				
				Categoria c = new Categoria();
				Tamanho t = new Tamanho();
				
				c.setId(rs.getInt("categoria_id"));
				c.setCategoria(rs.getString("categoria"));
				t.setId(rs.getInt("tamanho_id"));
				t.setTamanho(rs.getString("tamanho"));
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setCategoria(c);
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getString("imagem"));
				p.setTamanho(t);
				
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return p;

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProdutoDao dao = new ProdutoDao();
		System.out.println(dao.listSweetPizza());
	}


	
	
	
	

}
