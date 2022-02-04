package com.example.um_planner_java;


import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.um_planner_java.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    // Identifiant du téléchargement
    private long downloadID;

    // Receveur qui écoute quand le fichier est recus.
    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                //Toast.makeText(getContext(), "Download Completed", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        }
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        requireActivity().registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                String getUrl = "https://proseconsult.umontpellier.fr/jsp/custom/modules/plannings/direct_cal.jsp?data=58c99062bab31d256bee14356aca3f2423c0f022cb9660eba051b2653be722c4a5f10b982f9b914f8b3df9a16d82f493dc5c094f7d1a811b903031bde802c7f56c5ce5d7b8d9b880fb6990772f87c6e42988e4003796ffd7b370c710463ddfae935a1cf1cb9242dad5cce9713b0bbcb9352abd8b23259769b84175e9ee785c7b,1";
                //String getUrl = "https://geo.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2FGEO.2Fvar.2Fgeo.2Fstorage.2Fimages.2Fmedia.2Fsa-domestication-n-a-pas-emousse-l-instinct-de-ce-chasseur-hors-pair.2F2052028-1-fre-FR.2Fsa-domestication-n-a-pas-emousse-l-instinct-de-ce-chasseur-hors-pair.2Ejpg/1150x647/background-color/ffffff/quality/70/chat-quand-minou-devient-un-tueur-en-serie.jpg";

                String title = URLUtil.guessFileName(getUrl, null, null);

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl));
                request.setTitle(title);
                request.setDescription("Downloading...");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadID = downloadManager.enqueue(request);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}