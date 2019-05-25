package com.example.myresume.view

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.myresume.R
import com.example.myresume.ResumeApplication
import com.example.myresume.adapters.AdapterPastJobs
import com.example.myresume.adapters.AdapterResumeAbilities
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.domain.models.BasicsData
import com.example.myresume.domain.models.AbilitiesData
import com.example.myresume.domain.models.PastJobData
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.presenter.MainActivityContract
import com.example.myresume.presenter.ResumePresenter
import com.example.myresume.services.PicassImageDownloader
import javax.inject.Inject

class MainActivity : AppCompatActivity(), CommonView, MainActivityContract.View {

    private var skillsRecyclerView: RecyclerView? = null
    private var previousWorksRecyclerView: RecyclerView? = null
    private var progressBar: LottieAnimationView? = null
    private var infoContainer: ConstraintLayout? = null
    private var profileName: TextView? = null
    private var profileImage: ImageView? = null
    private var profileDescription: TextView? = null
    private var skillsTitle: TextView? = null
    private var placeholderContainer: View? = null

    private var adapterResumeAbilities: AdapterResumeAbilities? = null
    private var adapterPastJobs: AdapterPastJobs? = null

    private val imageDownloader = PicassImageDownloader()

    @Inject
    lateinit var stringsResolver: StringsResolver
    @Inject
    lateinit var getResumeInteractor: GetResumeInteractor

    private val resumePresenter by lazy {
        ResumePresenter(
            this,
            stringsResolver,
            getResumeInteractor,
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as ResumeApplication).getAppComponent().inject(this)
        resumePresenter.initView()
    }

    override fun onResume() {
        super.onResume()
        resumePresenter.downloadResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        resumePresenter.disposeSubscriptions()
    }

    override fun initView() {
        progressBar = this.findViewById(R.id.lottie_loading)
        skillsRecyclerView = this.findViewById(R.id.skills_list)
        previousWorksRecyclerView = this.findViewById(R.id.work_experience_list)
        profileName = this.findViewById(R.id.tv_profile_name)
        profileImage = this.findViewById(R.id.iv_profile_image)
        profileDescription = this.findViewById(R.id.tv_profile_description)
        infoContainer = this.findViewById(R.id.info_container)
        skillsTitle = this.findViewById(R.id.tv_profile_main_skill)
//        placeholderContainer = this.findViewById(R.id.container_placeholder)
    }

    override fun renderBasicInformation(basicInformation: BasicsData) {
        infoContainer?.visibility = VISIBLE
        placeholderContainer?.visibility = GONE
        profileName?.text = basicInformation.name
        profileDescription?.text = basicInformation.summary
        profileImage?.let { imageDownloader.loadImage(it, basicInformation.picture) }
    }

    override fun renderSkillsInformation(abilitiesInformation: List<AbilitiesData>) {
        val receivedSkill = abilitiesInformation[0]
        skillsTitle?.text = receivedSkill.name
        if (adapterResumeAbilities == null) {
            adapterResumeAbilities = AdapterResumeAbilities(receivedSkill.keywords?.toMutableList())
            skillsRecyclerView?.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.HORIZONTAL, false)
                adapter = adapterResumeAbilities
            }
        } else {
            adapterResumeAbilities?.refreshData(receivedSkill.keywords?.toMutableList())
        }
    }

    override fun renderWorksInformation(pastJobInformation: List<PastJobData>) {
        if (adapterPastJobs == null) {
            adapterPastJobs = AdapterPastJobs(ArrayList(pastJobInformation), imageDownloader, stringsResolver)
            previousWorksRecyclerView?.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                adapter = adapterPastJobs
            }
        } else {
            adapterPastJobs?.loadData(ArrayList(pastJobInformation))
        }
    }

//    override fun showResumePlaceHolder() {
//        infoContainer?.visibility = GONE
//        placeholderContainer?.visibility = VISIBLE
//    }

    override fun showError(errorMessage: String) {
        Snackbar.make(profileName as View, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar?.visibility = VISIBLE
    }

    override fun hideProgressBar() {
        progressBar?.visibility = GONE
    }
}
