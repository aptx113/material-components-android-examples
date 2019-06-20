/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.materialstudies.owl.ui.featured

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.materialstudies.owl.R
import com.materialstudies.owl.databinding.FeaturedItemBinding
import com.materialstudies.owl.model.Course
import com.materialstudies.owl.model.CourseDiff

class FeaturedAdapter : ListAdapter<Course, FeaturedViewHolder>(CourseDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        val binding = FeaturedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).apply {
            root.setOnClickListener {
                findNavController(it).navigate(R.id.learn)
            }
        }
        return FeaturedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class FeaturedViewHolder(
    private val binding: FeaturedItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(course: Course) {
        binding.run {
            this.course = course
            executePendingBindings()
        }
    }

}
