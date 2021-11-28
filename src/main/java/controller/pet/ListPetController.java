package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.dto.Pet;
import model.service.PetManager;

public class ListPetController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String userId = UserSessionUtils.getLoginUserId(session);

		// 로그인한 유저의 반려동물 리스트
		PetManager petMan = PetManager.getInstance();
		List<Pet> listPet = petMan.findPetListOfMember(userId);
		request.setAttribute("petList", listPet);

		return "/member/petView.jsp";
	}

}
