package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIDEV_OTDAV.entity.Declaration;

@Remote
public interface DeclarationServiceRemote {




	public Declaration find(int id);
	public List<Declaration> all();
	public Declaration addDeclaration(Declaration declaration);
	public void update(Declaration declaration);
	public void delete(int declarationId);

}
