/**
 * 新启工作室
 * Copyright (c) 1994-2015 All Rights Reserved.
 */
package com.xqsight.cms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xqsight.common.model.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>招聘表实体类</p>
 * <p>Table: cms_job - --> CmsJob</p>
 * <p>招聘表</p>
 * @since 2017-02-23 04:52:11
 * @author wangganggang
 */
public class CmsJob extends BaseModel {

	/** 主键 */
    private Long jobId;

    /** position_id - 职位内码 */
    private Long positionId;
    /** job_name - 招聘名称 */
    private String jobName;
    /** job_start_time - 招聘开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime jobStartTime;
    /** job_end_time - 招聘结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime jobEndTime;
    /** job_content - 招聘内容 */
    private String jobDepartment;
    /** job_phone - 电话 */
    private String jobPhone;
    /** jobType - 状态 0:全职1:兼职 */
    private Byte jobType;
    /** job_address - 地点 */
    private String jobAddress;

    /** position_desp - 职位描述 */
    private String positionDesp;

    /** job_need - 岗位需求 */
    private String jobNeed;

    /** job_email - 邮箱 */
    private String jobEmail;

    public Long getJobId(){
        return this.jobId;
    }
    public void setJobId(Long jobId){
        this.jobId = jobId;
    }
	public Long getPositionId(){
        return this.positionId;
    }
    public void setPositionId(Long positionId){
        this.positionId = positionId;
    }
	public String getJobName(){
        return this.jobName;
    }
    public void setJobName(String jobName){
        this.jobName = jobName;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getJobStartTime(){
        return this.jobStartTime;
    }
    public void setJobStartTime(LocalDateTime jobStartTime){
        this.jobStartTime = jobStartTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getJobEndTime(){
        return this.jobEndTime;
    }
    public void setJobEndTime(LocalDateTime jobEndTime){
        this.jobEndTime = jobEndTime;
    }
	public String getJobDepartment(){
        return this.jobDepartment;
    }
    public void setJobDepartment(String jobDepartment){
        this.jobDepartment = jobDepartment;
    }
	public String getJobPhone(){
        return this.jobPhone;
    }
    public void setJobPhone(String jobPhone){
        this.jobPhone = jobPhone;
    }
	public String getJobAddress(){
        return this.jobAddress;
    }

    public Byte getJobType() {
        return jobType;
    }

    public void setJobType(Byte jobType) {
        this.jobType = jobType;
    }

    public void setJobAddress(String jobAddress){
        this.jobAddress = jobAddress;
    }

    public String getPositionDesp() {
        return positionDesp;
    }

    public void setPositionDesp(String positionDesp) {
        this.positionDesp = positionDesp;
    }

    public String getJobNeed() {
        return jobNeed;
    }

    public void setJobNeed(String jobNeed) {
        this.jobNeed = jobNeed;
    }

    public String getJobEmail() {
        return jobEmail;
    }

    public void setJobEmail(String jobEmail) {
        this.jobEmail = jobEmail;
    }

    @Override
    public Serializable getPK() {
        return this.jobId;
    }
}