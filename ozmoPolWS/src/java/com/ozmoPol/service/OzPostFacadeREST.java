/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozmoPol.service;

import com.ozmoPol.OzPost;
import com.ozmoPol.OzRoom;
import com.ozmoPol.custom.CstResult;
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
@Path("com.ozmopol.ozpost")
public class OzPostFacadeREST extends AbstractFacade<OzPost> {

    @PersistenceContext(unitName = "ozmoPolWSPU")
    private EntityManager em;

    public OzPostFacadeREST() {
        super(OzPost.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(OzPost entity) {
        super.create(entity);
    }

    @POST
    @Path("createPost")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public CstResult createPost(OzPost entity) {
        CstResult res = new CstResult();
        try {
            this.create(entity);
            res.setTitle("OK");
            res.setMessage("Post created !");

        } catch (Exception e) {
            res.setTitle("NOK");
            res.setMessage(e.getLocalizedMessage());
        }

        return res;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") String id, OzPost entity) {
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
    public OzPost find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<OzPost> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<OzPost> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
