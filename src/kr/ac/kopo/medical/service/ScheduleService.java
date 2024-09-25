package kr.ac.kopo.medical.service;

import java.sql.Timestamp;
import java.util.List;

import kr.ac.kopo.medical.dao.ScheduleDAO;
import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class ScheduleService {
	
	private ScheduleDAO dao;
	
	public ScheduleService() {
		dao = new ScheduleDAO();
	}

	/**
	 *		UserService
	 */
	
	// 1. 진료예약
	public String addSchedule(TreatmentScheduleVO ts) {
		try {
			if (dao.isTimeSlotTaken(ts.getVetName() ,Timestamp.valueOf(ts.getScheduleDate()))) {
				return "해당 시간의 진료예약은 마감되었습니다. 예약을 다시 진행해주세요";
			}
			
			dao.insertSchedule(ts);
			return "예약신청이 완료되었습니다. 승인여부를 확인해주세요";
					
		} catch (Exception e) {
			return "알 수 없는 오류가 발생했습니다. 다시 진행하시거나 전화예약바랍니다";
		}
	}

	
	// 2. 진료예약 조회
	public List<TreatmentScheduleVO> enquireSchedule(String userId) {
		List<TreatmentScheduleVO> list = dao.selectSchedule(userId);		
		return list;
	}

	
	// 3. 진료일정 변경
	public void modifySchedule(TreatmentScheduleVO ts) {
		dao.updateSchedule(ts);
	}

	
	// 4. 진료예약 취소
	public void cancelReservation(String scheduleId) {
		dao.deleteReservation(scheduleId);
	}

	
	
	
	
	
	
	
	/**
	 *		AdminService
	 */	
	
	//1. 전체 진료일정 조회
	public List<TreatmentScheduleVO> searchAllSchedule() {
		List<TreatmentScheduleVO> list = dao.selectAllSchedule();
		return list;
	}

	
	// 2. 수의사별 진료일정 조회
	public List<TreatmentScheduleVO> enquireTask(String vetName) {
		List<TreatmentScheduleVO> list = dao.selectTask(vetName);
		return list;
	}

	
	// 3. 예약관리
	public void approveSchedule(TreatmentScheduleVO ts) {
		dao.confirmSchedule(ts);
	}

}
