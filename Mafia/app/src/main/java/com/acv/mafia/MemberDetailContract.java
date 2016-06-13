package com.acv.mafia;

import com.acv.mafia.model.Member;
import com.acv.mafia.presenter.CyclePresenter;
import com.acv.mafia.view.LoadDataView;

import java.util.Collection;
import java.util.List;

public interface MemberDetailContract {

    interface View extends LoadDataView{
        void renderMember(Member member);
        void renderBoss(Member member);
        void renderSubordinates(List<Member> merbers);
    }

    interface Presenter extends CyclePresenter {
        void loadMember();
        void loadSubordinates();
        void loadBoss();
    }
}
