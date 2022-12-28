package com.example.banglayoutube.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.banglayoutube.R;
import com.example.banglayoutube.adapters.VideoPostAdapter;
import com.example.banglayoutube.models.YoutubeDataModel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelFragment extends Fragment {
    private final static String GOOGLE_YOUTUBE_API_KEY ="AIzaSyDtM7bU5Gdxm83ENTOODZv1fwadmolyOYo";
    private final static String CHANNEL_ID = "UCr-_La9heBB6VgT9e1AW8hg";
    private final static String CHANNEL_GET_URL = "https://www.googleapis.com/youtube/v3/search?snippet&order=date&channelId=" + CHANNEL_ID + " &maxResults=20&key=" + GOOGLE_YOUTUBE_API_KEY + "";
    private RecyclerView mListVideos = null;
    VideoPostAdapter adapter = null;
    ArrayList<YoutubeDataModel> mListData = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChannelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChannelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChannelFragment newInstance(String param1, String param2) {
        ChannelFragment fragment = new ChannelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        mListVideos = (RecyclerView) view.findViewById(R.id.mListVideos);
        initList();
        new RequestYoutubeAPI().execute();
        return view;
    }

    private void initList() {
        mListData = new ArrayList<>();
        mListVideos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoPostAdapter(mListData, getActivity());
        mListVideos.setAdapter(adapter);
    }

    //AsyncTask initialize here
    private static class RequestYoutubeAPI extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(CHANNEL_GET_URL);
            try {
                HttpResponse response=httpClient.execute(httpGet);
                HttpEntity httpEntity=response.getEntity();
                String json= EntityUtils.toString(httpEntity);
                return json;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if(response !=null){
                try {
                    JSONObject object=new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}