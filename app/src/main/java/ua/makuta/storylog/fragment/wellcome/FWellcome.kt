package ua.makuta.storylog.fragment.wellcome

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import ua.makuta.storylog.BuildConfig
import ua.makuta.storylog.R
import ua.makuta.storylog.core.CoreFragment

class FWellcome : CoreFragment() {

    private lateinit var info : CardView
    private lateinit var ver : TextView

    private lateinit var cardDroid : CardView
    private lateinit var cardApple : CardView

    private lateinit var ad : AdView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wellcome, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        info = view.findViewById(R.id.view_card)
        ver = view.findViewById(R.id.view_ver)
        ad = view.findViewById(R.id.adView)
        ad.loadAd(AdRequest.Builder().build())

        cardDroid = view.findViewById(R.id.card_android)
        cardApple = view.findViewById(R.id.card_ios)

        cardDroid.setOnClickListener {
            findNavController().navigate(R.id.action_FWellcome_to_FAndroid)
        }

        cardApple.setOnClickListener {
            findNavController().navigate(R.id.action_FWellcome_to_FIos)
        }

        info.setOnClickListener {
            findNavController().navigate(R.id.action_FWellcome_to_FLicenses)
        }

        ver.text = "v. ${BuildConfig.VERSION_NAME}"
    }
}