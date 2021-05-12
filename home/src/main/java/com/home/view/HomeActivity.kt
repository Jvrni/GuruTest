package com.home.view

import android.os.Bundle
import com.core.base.BaseActivity
import com.home.R
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.architecture.ext.viewModel
import com.domain.models.Story

class HomeActivity : BaseActivity<HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        storyHome.setAdapter(
            listOf(
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                ),
                Story(
                    title = "BB BI vê bom resultado da Usiminas (USIM5) já precificado em ação e eleva preço-alvo",
                    origin = "Suno",
                    link = "https://www.suno.com.br/noticias/?p=142116",
                    isPriority = false,
                    image = "https://storage.googleapis.com/wp-noticias/2021/04/d62cfc0f-usiminas.jpg",
                    published = "2021 - 04 - 26 T13 :52:24:000 + 0000"
                )
            )
        )
    }
}