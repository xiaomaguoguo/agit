package com.madgag.agit.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.google.inject.Inject;
import com.madgag.agit.*;

import static com.madgag.agit.CommitViewerActivity.revCommitViewIntentFor;
import static com.madgag.agit.R.id.latest_commit;
import static com.madgag.agit.R.layout.latest_commit_view;

public class LatestCommitView extends FrameLayout implements EnabledListItem {
    private final RepoSummary repoSummary;

    @Inject
    public LatestCommitView(Context context, LayoutInflater layoutInflater, RepoSummary repoSummary) {
        super(context);
        this.repoSummary = repoSummary;
        layoutInflater.inflate(latest_commit_view, this);

        PrettyCommitSummaryView objectSummaryView = (PrettyCommitSummaryView) findViewById(latest_commit);
        objectSummaryView.setCommit(repoSummary.getLatestCommit());
        //objectSummaryView.setBackgroundColor(Color.YELLOW);
        objectSummaryView.setBackgroundResource(R.drawable.single_line_frame);
    }

    public void onItemClick() {
        getContext().startActivity(revCommitViewIntentFor(repoSummary.getRepo().getDirectory(), repoSummary.getLatestCommit().getId().name()));
    }
}
