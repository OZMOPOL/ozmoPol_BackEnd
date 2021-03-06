/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import UIClass.UIResult;
import com.ozmo.ent.OzRoom;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author sav
 */
@Stateless
@Path("com.ozmo.ent.ozroom")
public class OzRoomFacadeREST extends AbstractFacade<OzRoom> {

    @PersistenceContext(unitName = "ozmoPol_WS_GF3PU")
    private EntityManager em;

    public OzRoomFacadeREST() {
        super(OzRoom.class);
    }

    @POST
    @Path("createRoom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public UIResult createRoomByTitle(OzRoom entity) {
        UIResult res = new UIResult();

        try {
            super.create(entity);
            res.title = "OK";
            res.message = "Room Created!";
        } catch (Exception e) {
            res.title = "OK";
            res.message = e.getLocalizedMessage();
        }


        return res;
    }

    @PUT
    @Override
    @Consumes({"application/json"})
    public void edit(OzRoom entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public OzRoom find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<OzRoom> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<OzRoom> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @java.lang.Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
