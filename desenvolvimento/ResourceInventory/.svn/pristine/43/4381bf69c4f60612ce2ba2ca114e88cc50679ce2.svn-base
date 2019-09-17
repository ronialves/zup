package com.tlf.oss.resourceinventory.cpe.api.v1_0;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.cpe.core.CatalogController;
import com.tlf.oss.resourceinventory.cpe.entity.CaracteristicaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.vo.CaracteristicaDispositivoVo;
import com.tlf.oss.resourceinventory.cpe.vo.CatalogoDispositivoVo;
import com.tlf.oss.resourceinventory.cpe.vo.CategoriaDispositivoVo;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/catalog")
@Stateless
public class CatalogService extends RestInterceptor {

	@Inject
	private CatalogController catalogController;

	@GET
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doGet() throws OSSBusinessException {

		List<CatalogoDispositivo> listCatalog = catalogController.listAll();
		List<CatalogoDispositivoVo> listCatalogVo = new ArrayList<>();

		for (CatalogoDispositivo listCatalogEntity : listCatalog) {
			listCatalogVo.add(toCatalogoDispositivoVo(listCatalogEntity));
		}

		GenericEntity<List<CatalogoDispositivoVo>> entity = new GenericEntity<List<CatalogoDispositivoVo>>(listCatalogVo) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@GET 
	@Path("/vendors")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8) 
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doGetVendors() {

		List<String> vendors = catalogController.listAllVendors();
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
	    GenericEntity<String> entity = new GenericEntity<String>(gson.toJson(vendors)) {};
		
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@GET 
	@Path("/categories")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doGetCategories() {
		 List<CategoriaDispositivo> categorias = catalogController.listAllCategories();
		 List<CategoriaDispositivoVo> listCategoriesVo = new ArrayList<>();
		 
		for (CategoriaDispositivo categoria : categorias) {
			listCategoriesVo.add(toCategoriaDispositivoVo(categoria));
		}
		
		GenericEntity<List<CategoriaDispositivoVo>> entity = new GenericEntity<List<CategoriaDispositivoVo>>(listCategoriesVo) {};
		
		return Response.status(Status.OK).entity(entity).build();	
	}

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doPost(CatalogoDispositivoVo catalogo) throws OSSBusinessException {

		CatalogoDispositivo catalogoDispositivo = toCatalogoDispositivo(catalogo);
		catalogController.merge(catalogoDispositivo);
		
		return Response.status(Status.OK).entity(catalogo).build();
	}
	
	@PUT
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doPut(CatalogoDispositivoVo catalogo) throws OSSBusinessException {

		CatalogoDispositivo catalogoDispositivo = toCatalogoDispositivo(catalogo);
		catalogController.merge(catalogoDispositivo);
		
		return Response.status(Status.OK).entity(catalogo).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doDelete(@PathParam("id") int id) throws OSSBusinessException {
		catalogController.delete(id);

		return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doGetById(@PathParam("id") int id) throws OSSBusinessException {
		
		CatalogoDispositivo catalogoDispositivo = catalogController.getById(id);
		CatalogoDispositivoVo catalogVo = new CatalogoDispositivoVo();
		
		catalogVo = toCatalogoDispositivoVo(catalogoDispositivo);
		
		GenericEntity<CatalogoDispositivoVo> entity = new GenericEntity<CatalogoDispositivoVo>(catalogVo) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	private CatalogoDispositivoVo toCatalogoDispositivoVo(CatalogoDispositivo entity) throws OSSBusinessException {
		CatalogoDispositivoVo catalogoDispositivoVo = new CatalogoDispositivoVo();
		
		catalogoDispositivoVo.setId(entity.getId());
		catalogoDispositivoVo.setModelo(entity.getModelo());
		catalogoDispositivoVo.setFabricante(entity.getFabricante());
		catalogoDispositivoVo.setRede(entity.getRede());
		catalogoDispositivoVo.setCategoriaDispositivoId(entity.getCategoriaDispositivoId());
		catalogoDispositivoVo.setDescricao(entity.getDescricao());
		catalogoDispositivoVo.setSku(entity.getSku());
		catalogoDispositivoVo.setCategoriaDispositivo(toCategoriaDispositivoVo(entity.getCategoriaDispositivo()));
		
		List<CaracteristicaDispositivoVo> listCaracteristicaDispositivoVo = new ArrayList<>();
		
		for (CaracteristicaDispositivo listCaracteristicaDispositivo : entity.getCaracteristicas()) {
			
			CaracteristicaDispositivoVo caracteristicaDispositivoVo = new CaracteristicaDispositivoVo();
			
			caracteristicaDispositivoVo.setId(listCaracteristicaDispositivo.getId());
			caracteristicaDispositivoVo.setNome(listCaracteristicaDispositivo.getNome());
			caracteristicaDispositivoVo.setValor(listCaracteristicaDispositivo.getValor());
			
			listCaracteristicaDispositivoVo.add(caracteristicaDispositivoVo);
		}
		
		catalogoDispositivoVo.setCaracteristicas(listCaracteristicaDispositivoVo);
		catalogoDispositivoVo.setHasAssociatedDevices(catalogController.hasAssociatedDevices(entity));
		
		return catalogoDispositivoVo;
	}
	
	public CategoriaDispositivoVo toCategoriaDispositivoVo(CategoriaDispositivo categoria) {
		CategoriaDispositivoVo categoriaDispositivoVo = new CategoriaDispositivoVo();
		
		categoriaDispositivoVo.setId(categoria.getId());
		categoriaDispositivoVo.setNomeCategoria(categoria.getNomeCategoria());
		categoriaDispositivoVo.setTipoRfs(categoria.getTipoRfs());
		
		return categoriaDispositivoVo;
	}
	
	private CatalogoDispositivo toCatalogoDispositivo(CatalogoDispositivoVo catalogo) {
		CatalogoDispositivo catalogoDispositivo = new CatalogoDispositivo();
		
		catalogoDispositivo.setId(catalogo.getId());
		catalogoDispositivo.setModelo(catalogo.getModelo());
		catalogoDispositivo.setFabricante(catalogo.getFabricante());
		catalogoDispositivo.setRede(catalogo.getRede());
		catalogoDispositivo.setCategoriaDispositivoId(catalogo.getCategoriaDispositivo().getId());
		catalogoDispositivo.setDescricao(catalogo.getDescricao());
		catalogoDispositivo.setSku(catalogo.getSku());
		
		List<CaracteristicaDispositivo> listCaracteristicaDispositivo = new ArrayList<>();
		
		for (CaracteristicaDispositivoVo listCaracteristicaDispositivoVo : catalogo.getCaracteristicas()) {
			
			CaracteristicaDispositivo caracteristicaDispositivo = new CaracteristicaDispositivo();
			
			caracteristicaDispositivo.setId(listCaracteristicaDispositivoVo.getId());
			caracteristicaDispositivo.setNome(listCaracteristicaDispositivoVo.getNome());
			caracteristicaDispositivo.setValor(listCaracteristicaDispositivoVo.getValor());
			caracteristicaDispositivo.setCatalogo(catalogoDispositivo);
			
			listCaracteristicaDispositivo.add(caracteristicaDispositivo);
		}
		
		catalogoDispositivo.setCaracteristicas(listCaracteristicaDispositivo);
		
		return catalogoDispositivo;
	}
}
