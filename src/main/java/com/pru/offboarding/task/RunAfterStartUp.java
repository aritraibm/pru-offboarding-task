package com.pru.offboarding.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.pru.offboarding.task.entity.OffBoardingChecklist;
import com.pru.offboarding.task.entity.Recording;
import com.pru.offboarding.task.entity.Training;
import com.pru.offboarding.task.repo.OnBoardingChecklistRepo;
import com.pru.offboarding.task.repo.RecordingRepo;
import com.pru.offboarding.task.repo.TrainingRepo;



@Component
public class RunAfterStartUp {
	
	@Autowired
	private TrainingRepo trainingRepo;
	
	@Autowired
	private RecordingRepo recordingRepo;
	
	@Autowired
	private OnBoardingChecklistRepo onBoardingChecklistRepo;
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		//Trainings
		if(trainingRepo.findAll().isEmpty()) {
			trainingRepo.save(new Training("trainingName","link",""));
			trainingRepo.save(new Training("Security and Privacy for Developers 101","https://yourlearning.ibm.com/activity/PLAN-7D6F2B8A5C8F",""));
			trainingRepo.save(new Training("BCG","https://yourlearning.ibm.com/activity/WWBCG-BCG20220215",""));
			trainingRepo.save(new Training("IBM 2021-22 Data Privacy Training","https://yourlearning.ibm.com/activity/EL05-00000005",""));
			trainingRepo.save(new Training("IBM 2021-22 Annual Cybersecurity Education","https://yourlearning.ibm.com/activity/EL05-00000007",""));
			trainingRepo.save(new Training("California Consumer Privacy Act (CCPA)","https://yourlearning.ibm.com/activity/ILB-JYWQQXNPZZMZ22QK",""));
			trainingRepo.save(new Training("Prudential Financial DS&P Awareness Training","https://yourlearning.ibm.com/activity/EL01-00001940",""));
			trainingRepo.save(new Training("GBS Overarching Methodology","https://yourlearning.ibm.com/#activity/LT-4542",""));
			trainingRepo.save(new Training("Estimation Techniques","https://yourlearning.ibm.com/#activity/LT-4543",""));
			trainingRepo.save(new Training("GBS Methods & Tools Transformation","https://yourlearning.ibm.com/#activity/LT-4544",""));
			trainingRepo.save(new Training("GBS IBM Way & Methods","https://yourlearning.ibm.com/#activity/LT-4546",""));
			trainingRepo.save(new Training("GBS Tool Stacks","https://yourlearning.ibm.com/#activity/LT-4547",""));
			trainingRepo.save(new Training("KYI Entry - InstrainingIde Life Insurance","https://yourlearning.ibm.com/#activity/EL01-00001110",""));
			trainingRepo.save(new Training("KYI Entry - Introduction to Insurance","https://yourlearning.ibm.com/activity/EL01-00001111",""));
			trainingRepo.save(new Training("KYI Entry - InstrainingIde General Insurance","https://yourlearning.ibm.com/#activity/EL01-00001112",""));
			trainingRepo.save(new Training("KYI Foundation (For band 7 and above)","https://yourlearning.ibm.com/activity/PLAN-F0EAB6634998",""));
			trainingRepo.save(new Training("IBM General Data Protection Regulation Awareness","https://yourlearning.ibm.com/activity/SAI-IBM-EXDP02AIBM",""));
			System.out.println("Trainings created.....");
		}
		//Recordings
		if(recordingRepo.findAll().isEmpty()) {
			recordingRepo.save(new Recording("Onboarding document explanation","https://ibm.webex.com/ibm/ldr.php?RCID=4e40e391d818d4cfce42f6f4d1079a0c","cJaprjr6"));
			recordingRepo.save(new Recording("Offboarding document preparation","https://ibm.webex.com/ibm/ldr.php?RCID=6bf5ad8073a8e466b5a81be443307b15","Bbq6EpDP"));
			recordingRepo.save(new Recording("CSR modules recording","https://ibm.webex.com/ibm/ldr.php?RCID=8128d4b3059a5815f4c33fe75dca9c6c","fNMpjyA4"));
			recordingRepo.save(new Recording("Application KT on sponsor site","https://ibm.webex.com/ibm/ldr.php?RCID=827de3a9489408a325ad0c590c18be73","UiQ3EvdE"));
			recordingRepo.save(new Recording("Session for all onboarding documents","https://ibm.webex.com/ibm/ldr.php?RCID=fab2d475e14599106e0a617399166f23","3JuzKSKK"));
			recordingRepo.save(new Recording("ILC KT","https://ibm.webex.com/ibm/ldr.php?RCID=1f64d4b76e311f85689f843484ced646","tE3mimG5"));
			System.out.println("Recordings created.....");
		}
		//OnBoradingChecklists
		if(onBoardingChecklistRepo.findAll().isEmpty()) {
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member signed the Prudential NDA?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the new team member aware of the project team, project guidelines, work area facilities?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed IBM data privacy training? (collect the certificate)","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed IBM GBS Method training certificate?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the new workforce member is aware of the type of the information they will have access to (for example, Client sensitive information) in the systems, applications or databases they will have access to?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the team member aware of his roles and responsibilities, application/shared drive access details?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the new team member aware of project tools, applications and documents?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has BGC initiated for new team member?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Complete Data Privacy by Design &amp; Default which can be found on this page","N","","https://w3-connections.ibm.com/wikis/home?lang=en-us#!/wiki/W768710c93bb0_4dcd_aca9_7029bf9192c8/page/GBS%20Education%20%26%20Training","GBS GDPR Training"));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("If a sub processor, have they been approved by client?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed IBM BCG training?","N","","https://yourlearning.ibm.com/activity/URL-5C27BE7F0E72","BCM Training activity for year- 2020 onwards"));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the on boarding email sent to the new team member?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the Client aware of the new GBS workforce member, the role they will be performing, the systems they will be accessing and the type of access they will need.","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member got access project work area, seat and system?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the team member aware of ILC account id and bill code to be used for time clocking?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed IBM Cyber Security Training? (collect the certificate)","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Have you completed the KYI? If so, provide the date of completion and screen shot of the same. If not completed, KYI for insurance industry should be completed within 1 week of date of joining of the project.","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("If the new workforce member will have any privileged access, they are aware of workstation usage restrictions according to IBM standards (as defined in ITSS).&lt;br&gt;&lt;br&gt;Security+and+Use+Standards+for+IBM+Employees.htm","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Project documentation (roles and responsibilities, SOD, Workforce Member Master List, User ID Sheet) has been updated to include this new workforce member and the role they will be performing?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed Client specific DS&amp;P training and confirmed","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member got access to IBM systems - lotus notes, W3?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the Onsite lead/Manager sent new team member details and user id creation request mail to Prudential management?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Did you submit/update your Checkpoint goals aligned to your project goals for this year?","N","","https://w3.ibm.com/hr/web/performance/checkpoint","Checkpoint"));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed GDPR training?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed CCPA training?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the email request sent to IBM Onsite lead/Manager with the details of new team member to initiate the user id creation?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the Yellow port (Prudential network port) active at new team member's desk?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Is the new team memberâ€™s system compliant with ITSS and data being used.","N","","https://beekeeper.us1a.cirrus.ibm.com/","Beekeeper"));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("If applicable and a Corporate standard workstation exemption is needed for this workforce member, follow the corporate process to have this exemption granted.  This includes USB Write exemptions or Privileged Access operating system exemptions.","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member completed Project application specific induction?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the member been issued client badge to enter/access the Prudential premises?","N","","",""));
			onBoardingChecklistRepo.save(new OffBoardingChecklist("Has the new team member details are updated in Employee Dashboard and distribution list?","N","","",""));
			System.out.println("OnBoradingChecklists created.....");
		}
	}

}
