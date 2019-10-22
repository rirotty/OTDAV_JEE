package webRessources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.Declaration;
import tn.esprit.PIDEV_OTDAV.entity.Membership;
import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;
import tn.esprit.PIDEV_OTDAV.services.ArtworkService;
import tn.esprit.PIDEV_OTDAV.services.CategoryService;
import tn.esprit.PIDEV_OTDAV.services.DeclarationService;
import tn.esprit.PIDEV_OTDAV.services.MembershipService;
import tn.esprit.PIDEV_OTDAV.services.UserService;

@Path("memberships")
@RequestScoped
public class MembershipRessources {

	@EJB
	MembershipService ms;
	@EJB
	UserService userService;
	@EJB
	ArtworkService as;
	@EJB
	DeclarationService ds;
	@EJB
	CategoryService cs;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMembership() {

		List<Membership> l = ms.memberships();
		return Response.status(Status.OK).entity(l).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addMembership(Membership membership)

	{
		// User selectedUser = userService.findOnById(1);

		ms.addMembership(membership);

		return Response.status(Status.OK).entity("add successful").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public Response updateMembership(@PathParam(value = "id") int id, Membership membership) {

		if (ms.getMembershipById(id) != null) {

			Membership m2 = new Membership();
			m2 = ms.getMembershipById(id);

			if (membership.getRejectedFor() != null) {
				m2.setRejectedFor(membership.getRejectedFor());
			}

			if (membership.getStatus() != null) {
				m2.setStatus(membership.getStatus());
			}

			ms.update(m2);

			return Response.status(Status.OK).entity(ms.getMembershipById(id)).build();
		}
		return Response.status(Status.NOT_FOUND).entity("no membership found").build();
	}
	// kif haka maaneha? éyh w le5er consommation ? ah? fel .net ma7alitéch
	// visual ahna 5edmet el I knowwehed eli 9alou ye5Dmo u we he d w y p a r t
	// a gi hhhhhh I know ma7abetch taati I know how do u know I talk to rym yea
	// I know rym

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/artworks")
	public Response getArtwork() {

		List<Artwork> l = as.all();
		return Response.status(Status.OK).entity(l).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addArtwork")
	public Response addArtwork(Artwork artwork)

	{
		// User selectedUser = userService.findOnById(1);

		as.addArtwork(artwork);

		return Response.status(Status.OK).entity("add successful").build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addDeclaration")
	public Response addDeclaration(Declaration declaration)

	{
		// User selectedUser = userService.findOnById(1);

		ds.addDeclaration(declaration);

		return Response.status(Status.OK).entity("add successful").build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rejected")
	public Response getRejected() {

		Integer m = ms.mNotRejected();
		return Response.status(Status.OK).entity(m).build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sub")
	public Response getSubCat() {

		List<subCategory> l = cs.subCategories();
		return Response.status(Status.OK).entity(l).build();

	}
	
}
