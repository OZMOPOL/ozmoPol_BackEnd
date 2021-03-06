/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import OzClass.OzResult;
import entities.Vote;
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
 * @author amind
 */
@Stateless
@Path("entities.vote")
public class VoteFacadeREST extends AbstractFacade<Vote> {
    @PersistenceContext(unitName = "OzmopolPU")
    private EntityManager em;

    public VoteFacadeREST() {
        super(Vote.class);
    }

    @POST
    @Path("createVote")
    @Consumes({"application/json"})
    public OzResult createVote(Vote entity) {
        OzResult res=new OzResult();
        try {
            super.create(entity);
            res.title="OK";
        } catch (Exception e) {
            res.title="NOK";
            res.details=e.toString();
        }
        return res;
        
    }

    @PUT
    @Path("{id}")
    @Consumes({  "application/json"})
    public void edit(@PathParam("id") String id, Vote entity) {
        super.edit(entity);
    }
    
    @PUT
    @Path("editVote")
    @Consumes({"application/json"})
    public OzResult editVote(Vote vote) {
        OzResult res=new OzResult();
        try {
             super.edit(vote);
             res.title="OK";
        } catch (Exception e) {
            res.details=e.toString();                    
        }
       return res;
    }

    @DELETE
    @Path("{id}")
    public OzResult remove(@PathParam("id") String id) {
        OzResult res=new OzResult();
        try {
             super.remove(super.find(id));
             res.title="OK";
        } catch (Exception e) {
            res.details=e.toString();  
        }
       return res;
    }

    @GET
    @Path("{id}")
    @Produces({  "application/json"})
    public Vote find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({  "application/json"})
    public List<Vote> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({  "application/json"})
    public List<Vote> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
