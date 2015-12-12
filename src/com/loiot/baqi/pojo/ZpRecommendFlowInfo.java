package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 推荐流程 实体类
 * 
 * @author  wangzx 
 * @creation 2015-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpRecommendFlowInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long auditId;  //auditId db_column: audit_id 
	    private java.lang.Long companyJobId;  //公司职位 db_column: company_job_id 
	    private java.lang.Long jlId;  //简历id db_column: jl_id 
	    private java.lang.Long matchId;  //匹配id db_column: match_id 
	    private java.lang.String enterpriseName;  //enterpriseName db_column: enterprise_name 
	    private java.lang.Long technicianAuditPerson;  //技术审核人 db_column: technician_audit_person 
	    private java.lang.String technicianAuditContent;  //技术评审内容 db_column: technician_audit_content 
	    private java.util.Date technicianAuditTime;  //技术评审时间 db_column: technician_audit_time 
	    private Integer technicianAuditStatus;  //技术评审状态 db_column: technician_audit_status 
	    private java.lang.Long enterpriseDockingPerson;  //企业对接人 db_column: enterprise_docking_person 
	    private java.lang.Integer enterpriseDockingStatus;  //企业对接状态 db_column: enterprise_docking_status 
	    private java.util.Date enterpriseDockingTime;  //企业对接人反馈时间 db_column: enterprise_docking_time 
	    private long enterpriseReplyStatus;  //企业反馈状态 db_column: enterprise_reply_status 
	    private java.lang.String enterpriseReplyContent;  //企业反馈内容 db_column: enterprise_reply_content 
	    private java.util.Date enterpriseReplyTime;  //企业反馈时间 db_column: enterprise_reply_time 
	    private java.lang.String hrNoticePerson;  //hr通知人 db_column: hr_notice_person 
	    private java.lang.Long hrNoticeStatus;  //hr通知状态 db_column: hr_notice_status 
	    private java.util.Date hrNoticeTime;  //hr_通知时间 db_column: hr_notice_time 
	    private java.lang.String hrNoticeFeedbackContent;  //hr_通知后的反馈内容 db_column: hr_notice_feedback_content 
	    private java.util.Date enterpriseInvitationTime;  //企业要求面试时间 db_column: enterprise_invitation_time 
	    private java.util.Date hrBeforeNotifyHunterStatus;  //hr提前通知状态 db_column: hr_before_notify_hunter__status 
	    private java.util.Date hrBeforeNotifyHunterTime;  //hr提前通知时间 db_column: hr_before_notify_hunter__time 
	    private java.lang.Long hrBeforeNotifyHunterPerson;  //hrBeforeNotifyHunterPerson db_column: hr_before_notify_hunter__person 
	    private java.lang.Integer hunterGotoInterviewStatus;  //求职者是否已经去面试 db_column: hunter_goto_interview_status 
	    private java.lang.String hunterReplayContent;  //求职者反馈 db_column: hunter_replay_content 
	    private java.util.Date lastUpdateTime;  //最后更新时间 db_column: last_update_time 
	    private java.lang.Long lastUpdatePerson;  //最后更新人 db_column: last_update_person 
	    private java.util.Date inTime;  //录入时间 db_column: in_time 
	    private java.lang.Integer flowStatus;  //流程状态 db_column: flow_status 
	    private java.lang.Long inPerson;  //录入人 db_column: in_person 
	    private Long enterpriseInterfacePerson;//企业对接人
	    private Long headhunterInterfacePerson;//电话猎头对接人
	    private Integer hunterInterviewStatus;  //求职者面试反馈状态 db_column: hunter_interview_status 
	    private java.util.Date hunterInterviewOperatorTime;  //顾问操作时间 db_column: hunter_interview_operator_time 
	    private java.lang.String hunterInerviewReplayContent;  //求职者面试反馈内容 db_column: hunter_inerview_replay_content 
	    private java.util.Date hunterGotoInterviewOperatorTime;  //猎头顾问馈时间 db_column: hunter_goto_interview_operator_time 
	  
	  private java.lang.String inPersonName;
	  private String companyName;
	  private String companyJobName;  
	  private String jlName;
	  private String jlFilePath;
	  private String technicianAuditPersonName;  //技术审核人名称
	  private String enterpriseInterfacePersonName;//企业对接人名称
	  private String headhunterInterfacePersonName;//电话猎头对接人

	  

	public ZpRecommendFlowInfo(){
	}

	public ZpRecommendFlowInfo(
		java.lang.Long auditId
	){
		this.auditId = auditId;
	}

	
	
}

