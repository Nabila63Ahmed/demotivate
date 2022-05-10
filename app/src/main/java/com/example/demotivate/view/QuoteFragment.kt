package com.example.demotivate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.demotivate.R
import com.example.demotivate.viewmodel.QuotesViewModel


/**
 * A simple [Fragment] subclass.
 */
class QuoteFragment : Fragment() {
    private val model: QuotesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quoteTextView = view.findViewById<TextView>(R.id.quoteTextView)
        val authorTextView = view.findViewById<TextView>(R.id.authorTextView)

        val firstQuote = model.getFirstQuote()
        firstQuote.let {
            "\" ${it.quote}\"".also { it -> quoteTextView?.text = it }
            "- ${it.author}".also { it -> authorTextView?.text = it }
        }
//        quoteTextView.text = firstQuote.quote
//        authorTextView.text = firstQuote.author
    }
}
