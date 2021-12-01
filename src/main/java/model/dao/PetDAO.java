package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Member;
import model.dto.Pet;
import model.dto.PetKind;

public class PetDAO {
	private JDBCUtil jdbcUtil = null;

	public PetDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	public ArrayList<Pet> findPetListOfMember(String memberId) throws SQLException {
		String sql = "SELECT pet_id, name, birth, gender, kind_id, large_category, small_category "
				+ "FROM pet JOIN pet_kind USING (kind_id) " + "WHERE member_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { memberId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<Pet> petList = new ArrayList<>();

				Pet pet = new Pet(rs.getString("pet_id"));
				pet.setName(rs.getString("name"));
				pet.setBirth(rs.getString("birth"));
				pet.setGender(rs.getString("gender"));
				pet.setKind(new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
						rs.getString("small_category")));
				petList.add(pet);

				while (rs.next()) {
					pet = new Pet(rs.getString("pet_id"));
					pet.setName(rs.getString("name"));
					pet.setBirth(rs.getString("birth"));
					pet.setGender(rs.getString("gender"));
					pet.setKind(new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
							rs.getString("small_category")));
					petList.add(pet);
				}

				return petList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/* 보호자의 반려동물 중 선택한 돌보미가 돌봄 가능한 동물 리스트 */
	public List<Pet> findAbleCarePetList(String memberId, String sitterId) throws SQLException {
		String sql = "SELECT pet_id, name, birth, gender, kind_id, large_category, small_category "
				+ "FROM pet JOIN pet_kind USING (kind_id) " 
				+ "JOIN available_pet_kind apk USING (kind_id) "
				+ "WHERE member_id = ? AND apk.sitter_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { memberId, sitterId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<Pet> petList = new ArrayList<>();

				Pet pet = new Pet(rs.getString("pet_id"));
				pet.setName(rs.getString("name"));
				pet.setBirth(rs.getString("birth"));
				pet.setGender(rs.getString("gender"));
				pet.setKind(new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
						rs.getString("small_category")));
				petList.add(pet);

				while (rs.next()) {
					pet = new Pet(rs.getString("pet_id"));
					pet.setName(rs.getString("name"));
					pet.setBirth(rs.getString("birth"));
					pet.setGender(rs.getString("gender"));
					pet.setKind(new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
							rs.getString("small_category")));
					petList.add(pet);
				}

				return petList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/* 전체 반려동물 종 리스트 검색 */
	public ArrayList<PetKind> findAllPetKindList() throws SQLException {
		String sql = "SELECT kind_id, large_category, small_category "
				+ "FROM pet_kind "
				+ "ORDER BY large_category";

		jdbcUtil.setSqlAndParameters(sql, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<PetKind> petKindList = new ArrayList<>();
				PetKind petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
						rs.getString("small_category"));
				petKindList.add(petKind);
				while (rs.next()) {
					petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
							rs.getString("small_category"));
					petKindList.add(petKind);
				}
				return petKindList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/* 전체 돌보미의 돌봄 가능 종 리스트 검색 */
	public ArrayList<PetKind> findAllAblePetKindList() throws SQLException {
		String sql = "SELECT DISTINCT kind_id, large_category, small_category "
				+ "FROM available_pet_kind JOIN pet_kind USING (kind_id) "
				+ "ORDER BY large_category";

		jdbcUtil.setSqlAndParameters(sql, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<PetKind> petKindList = new ArrayList<>();
				PetKind petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
						rs.getString("small_category"));
				petKindList.add(petKind);
				while (rs.next()) {
					petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
							rs.getString("small_category"));
					petKindList.add(petKind);
				}
				return petKindList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	/* 특정 돌보미의 돌봄 가능 종 리스트 검색 */
	public ArrayList<PetKind> findAblePetKindList(String sitterId) throws SQLException {
		String sql = "SELECT kind_id, large_category, small_category "
				+ "FROM available_pet_kind JOIN pet_kind USING (kind_id) " + "WHERE sitter_id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { sitterId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<PetKind> petKindList = new ArrayList<>();
				PetKind petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
						rs.getString("small_category"));
				petKindList.add(petKind);
				while (rs.next()) {
					petKind = new PetKind(rs.getString("kind_id"), rs.getString("large_category"),
							rs.getString("small_category"));
					petKindList.add(petKind);
				}
				return petKindList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<String> findPetAttachments(String memberId, String petId) throws SQLException {
		String sql = "SELECT img_src " + "FROM attachment " + "WHERE member_id=? AND img_src LIKE ?";

		String like = "%pet-" + petId + "-%";
		like = like.replaceAll(" ", "");

		jdbcUtil.setSqlAndParameters(sql, new Object[] { memberId, like }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<String> imgList = new ArrayList<String>();
			if (rs.next()) {
				String img_src = rs.getString("img_src");
				imgList.add(img_src);

				while (rs.next()) {
					img_src = rs.getString("img_src");
					imgList.add(img_src);
				}
				return imgList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/* 돌봄 내역에 해당하는 반려동물 리스트 조회  */
	public ArrayList<Pet> findCarePetList(Integer careId) throws SQLException {
		String sql = "SELECT DISTINCT pet_id, name, birth, gender, kind_id "
				+ "FROM pet JOIN receive_service USING (pet_id) " 
				+ "WHERE care_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { careId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				ArrayList<Pet> petList = new ArrayList<>();
				Pet pet = new Pet(rs.getString("pet_id"));
				pet.setName(rs.getString("name"));
				pet.setBirth(rs.getString("birth"));
				pet.setGender(rs.getString("gender"));
				pet.setKind(new PetKind(rs.getString("kind_id")));
				petList.add(pet);
				while (rs.next()) {
					pet = new Pet(rs.getString("pet_id"));
					pet.setName(rs.getString("name"));
					pet.setBirth(rs.getString("birth"));
					pet.setGender(rs.getString("gender"));
					pet.setKind(new PetKind(rs.getString("kind_id")));
					petList.add(pet);
				}
				return petList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public Pet findPetInfo(String petId) throws SQLException {
		String sql = "SELECT pet_id, name, birth, gender, member_id, kind_id "
				+ "FROM pet " 
				+ "WHERE pet_id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { petId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Pet pet = new Pet (
							petId,
							rs.getString("name"),
							rs.getString("birth"),
							rs.getString("gender"),
							new PetKind(rs.getString("kind_id")),
							new Member(rs.getString("member_id"))
						);
				
				return pet;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public int addPet(String memberId, Pet pet) {
		 String sql = "INSERT INTO PET VALUES (?, ?, ?, ?, ?, ?)";
		 String petId = pet.getBirth().replaceAll("-", "").substring(2, 8) + memberId.substring(memberId.length() - 2, memberId.length()); // 수정 필요
         
		 Object[] param = new Object[] {petId , pet.getName(), pet.getBirth(), pet.getGender(), 
				 memberId, pet.getKind().getId() };   
         jdbcUtil.setSqlAndParameters(sql, param);

	      try {
	    	  int recordCount = jdbcUtil.executeUpdate();
	    	  
	    	  return recordCount;
	      } catch (Exception ex) {
	          jdbcUtil.rollback();
	    	  ex.printStackTrace();
	      } finally {
	    	 jdbcUtil.commit();
	         jdbcUtil.close();      
	      }
		   return 0;
	}
	
	public PetKind findPetKindInfo(String kindId) {
		String sql = "SELECT kind_id, large_category, small_category "
				+ "FROM pet_kind " 
				+ "WHERE kind_id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { kindId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				PetKind petKind = new PetKind (
							kindId, rs.getString("large_category"), rs.getString("small_category")
						);
				
				return petKind;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
