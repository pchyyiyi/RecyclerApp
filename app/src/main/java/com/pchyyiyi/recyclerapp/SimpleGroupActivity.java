package com.pchyyiyi.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pchyyiyi.recyclerapp.group.GroupItemDecoration;
import com.pchyyiyi.recyclerapp.group.GroupRecyclerAdapter;
import com.pchyyiyi.recyclerapp.group.OnChildClickListener;
import com.pchyyiyi.recyclerapp.group.OnGroupClickListener;
import com.pchyyiyi.recyclerapp.groupbean.Member;
import com.pchyyiyi.recyclerapp.groupbean.MemberViewHolder;
import com.pchyyiyi.recyclerapp.groupbean.Team;
import com.pchyyiyi.recyclerapp.groupbean.TeamViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView用法：简单分组显示
 */
public class SimpleGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_group);


        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Member> members = new ArrayList<>();
            String teamName = Character.toString((char) ((int) ('A') + i)) + "队";
            for (int j = 0; j < 10; j++) {
                members.add(new Member("姓名" + j, teamName + j));
            }
            teams.add(new Team(teamName, members));
        }

        final LayoutInflater layoutInflater = LayoutInflater.from(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final GroupRecyclerAdapter<Team, TeamViewHolder, MemberViewHolder> recyclerAdapter =
                new GroupRecyclerAdapter<Team, TeamViewHolder, MemberViewHolder>(teams) {
                    @Override
                    protected TeamViewHolder onCreateGroupViewHolder(ViewGroup parent) {
                        return new TeamViewHolder(layoutInflater.inflate(R.layout.item_simple_team_title, parent, false));
                    }

                    @Override
                    protected MemberViewHolder onCreateChildViewHolder(ViewGroup parent) {
                        return new MemberViewHolder(layoutInflater.inflate(R.layout.item_simple_team_member, parent, false));
                    }

                    @Override
                    protected void onBindGroupViewHolder(TeamViewHolder holder, int groupPosition) {
                        holder.update(getGroup(groupPosition));
                    }

                    @Override
                    protected void onBindChildViewHolder(MemberViewHolder holder, int groupPosition, int childPosition) {
                        holder.update(getGroup(groupPosition).members.get(childPosition));
                    }

                    @Override
                    protected int getChildCount(Team group) {
                        return group.members.size();
                    }
                };
        recyclerView.setAdapter(recyclerAdapter);

        GroupItemDecoration decoration = new GroupItemDecoration(recyclerAdapter);
        decoration.setGroupDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_height_16_dp, null));
        decoration.setTitleDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_height_1_px, null));
        decoration.setChildDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_white_header, null));
        recyclerView.addItemDecoration(decoration);

        recyclerAdapter.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public void onGroupItemClick(View itemView, int groupPosition) {
                showToast(recyclerAdapter.getGroup(groupPosition).title);
            }
        });
        recyclerAdapter.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public void onChildClick(View itemView, int groupPosition, int childPosition) {
                Team team = recyclerAdapter.getGroup(groupPosition);
                showToast(team.title + ": " +team.members.get(childPosition).name);
            }
        });

    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}