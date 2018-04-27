
package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class BATResponse {

    @SerializedName("changes")
    private List<Change> mChanges;
    @SerializedName("deleted")
    private List<Object> mDeleted;
    @SerializedName("lastSeq")
    private String mLastSeq;
    @SerializedName("pending")
    private Long mPending;

    public List<Change> getChanges() {
        return mChanges;
    }

    public void setChanges(List<Change> changes) {
        mChanges = changes;
    }

    public List<Object> getDeleted() {
        return mDeleted;
    }

    public void setDeleted(List<Object> deleted) {
        mDeleted = deleted;
    }

    public String getLastSeq() {
        return mLastSeq;
    }

    public void setLastSeq(String lastSeq) {
        mLastSeq = lastSeq;
    }

    public Long getPending() {
        return mPending;
    }

    public void setPending(Long pending) {
        mPending = pending;
    }

}
