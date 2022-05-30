package com.example.demotivate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.demotivate.databinding.FragmentQuoteBinding
import com.example.demotivate.viewmodel.QuotesViewModel


/**
 * A simple [Fragment] subclass.
 */
class QuoteFragment : Fragment() {
    private val model: QuotesViewModel by activityViewModels()
    lateinit var binding: FragmentQuoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstQuote = model.getFirstQuote()
        "\"${
            firstQuote.quote
                .replace("\"", "")
                .replace("\u201C", "")
                .replace("\u201D", "")
        }\""
            .also { binding.quoteTextView.text = it }
        "- ${firstQuote.author}".also { binding.authorTextView.text = it }
    }
}
