/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.UUID;
import com.ozmo.ent.Xuserflwroom;
import com.ozmo.ent.OzRoom;
import com.ozmo.ent.OzUser;
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
@Path("com.ozmo.ent.xuserflwroom")
public class XuserflwroomFacadeREST extends AbstractFacade<Xuserflwroom> {
    @PersistenceContext(unitName = "ozmoPol_WS_GF3PU")
    private EntityManager em;

    public XuserflwroomFacadeREST() {
        super(Xuserflwroom.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Xuserflwroom entity) {
        super.create(entity);
    }

//    @POST
//    @Path("{userId}/{roomId}")
//    @Consumes({"application/json"})
//    public void userFollowRoom(String userId, String roomId) {
//        Xuserflwroom entity = new Xuserflwroom();
//        
//        List<OzRoom> roomList = em.createNamedQuery("OzRoom.findByPkRoomId").setParameter("roomId", roomId).getResultList();
//        List<OzUser> userList = em.createNamedQuery("OzUser.findByPkUserId").setParameter("userId", userId).getResultList();
//        
//        OzUser theUser = userList.get(0);
//        OzRoom theRoom = roomList.get(0);
//        
//        String randID = UUID.randomUUID().toString();
//        
//        entity.setFkuserXroomroomid(theRoom);
//        entity.setFkuserXroomuserid(theUser);
//        entity.setPkuserXroomid(randID);
//        
//        super.create(entity);
//    }
    
    @PUT
    @Override
    @Consumes({"application/json"})
    public void edit(Xuserflwroom entity) {
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
    public Xuserflwroom find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Xuserflwroom> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Xuserflwroom> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
