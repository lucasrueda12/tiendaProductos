package besysoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaTienda {
	private Map<Vendedor, List<Producto>> _ventas;
	private DataBase db;
	
	public SistemaTienda() {
		db = new DataBase();
		_ventas = new HashMap<>();
	}
	
	public void registrarVenta(Integer codProduct, Integer codVendedor) {
		if(codProduct == null  || codProduct <1 ) {
			throw new RuntimeException("codigo de producto invalido");
		}
		if(codVendedor == null || codVendedor<1) {
			throw new RuntimeException("codigo de vendedor Invalido");
		}
		
		Producto p= db.traerProducto(codProduct);
		Vendedor v= db.traerVendedor(codVendedor);
		
		if(_ventas.containsKey(v)){
			_ventas.get(v).add(p);
		}else {
			_ventas.put(v, new ArrayList<>());
			_ventas.get(v).add(p);
		}
	}
	
	public double calcularComision(Integer codVendedor) {
		if(codVendedor == null || codVendedor<1) {
			throw new RuntimeException("codigo de vendedor Invalido");
		}
		
		Vendedor v= db.traerVendedor(codVendedor);
		
		if(!_ventas.containsKey(v)) {
			return 0;
		}
		
		double count=0;
		for(Producto p: _ventas.get(v)) {
			count += p.get_precio();
		}
		if(_ventas.get(v).size()>2) {
			return count * 0.10;
		}else {
			return count * 0.5;
		}
	}
	
	public List<Producto> buscarPorCategoria(String categoria){
		if(categoria == null || categoria.isEmpty()){
			throw new RuntimeException("Categoria invalida");
		}
		
		return db.traerPorCategoria(categoria);
	}
	
	public Producto buscarPorNombre(String nombre) {
		if(nombre == null || nombre.isEmpty()){
			throw new RuntimeException("Categoria invalida");
		}
		
		return db.traerPorNombre(nombre);
	}
	
	public Producto buscarPorId(Integer codProducto) {
		if(codProducto == null  || codProducto <1 ) {
			throw new RuntimeException("codigo de producto invalido");
		}
		
		return db.traerProducto(codProducto);
	}
	
	
	public static void main(String[] args) {
		SistemaTienda st = new SistemaTienda();
		st.registrarVenta(1, 1);
		st.registrarVenta(2, 1);
		st.registrarVenta(3, 1);
		st.registrarVenta(1, 2);
		st.registrarVenta(3, 3);
		
		System.out.println(st.calcularComision(1));
		System.out.println(st.calcularComision(2));
		System.out.println(st.calcularComision(3));
		
		
		
	}
}
