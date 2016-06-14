package com.acv.mafia;

import com.acv.mafia.model.Member;
import com.acv.mafia.presenter.CyclePresenter;
import com.acv.mafia.view.LoadDataView;

import java.util.Collection;

public interface MemberListContract {

    interface View extends LoadDataView{
        void renderMemberList(Collection<Member> members);
    }

    interface Presenter extends CyclePresenter {
        void loadMembers();
    }
}
