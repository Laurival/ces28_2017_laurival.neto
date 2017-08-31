package aula06_refact;

public class School {

	public ApplicationResult register(Applicant applicant) {
		
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationDao();
		
		boolean result = applicationValidation.validate(applicant);
		if (result) {
			result = admissionApplicationDao.persist(applicant);
			if (result) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
			} else {
				retResult.setSuccess(false);
				retResult.setMessage("Admission application fail");
			}
		} else {
			retResult.setSuccess(false);
			retResult.setMessage("Admission application fail");
		}
		return retResult;
		
	}
	public ApplicationDao getApplicationDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
